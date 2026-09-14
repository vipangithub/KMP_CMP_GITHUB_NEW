package com.example.cmpshop.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cmpshop.domain.model.Product
import com.example.cmpshop.domain.usercase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductionViewModel(
    private val useCase: GetProductUseCase
): ViewModel() {
    private  val _uiState = MutableStateFlow(ProductUiState())
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _uiState.value = ProductUiState(isLoading = true)
            try {
                val product = useCase()
                _uiState.value = ProductUiState(
                    isLoading = false,
                    product = product)
            }catch (exception: Exception){
                _uiState.value = ProductUiState(
                    isLoading = false,
                    error = exception.message
                        ?: "Unknown error"
                )
            }
        }
//         val sampleProducts = listOf(
//            Product(
//                id = 1,
//                title = "Laptop",
//                price = 55000.0
//            ),
//            Product(
//                id = 2,
//                title = "Phone",
//                price = 30000.0
//            ),
//            Product(
//                id = 3,
//                title = "Headphones",
//                price = 5000.0
//            )
//        )
//        _uiState.value = ProductUiState(
//            isLoading = false,
//            product = sampleProducts
//        )
    }
}