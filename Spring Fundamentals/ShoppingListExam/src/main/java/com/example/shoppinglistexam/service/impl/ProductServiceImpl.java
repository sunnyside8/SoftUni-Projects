package com.example.shoppinglistexam.service.impl;

import com.example.shoppinglistexam.model.entity.Category;
import com.example.shoppinglistexam.model.entity.CategoryEnum;
import com.example.shoppinglistexam.model.entity.Product;
import com.example.shoppinglistexam.model.service.ProductServiceModel;
import com.example.shoppinglistexam.model.view.ProductViewModel;
import com.example.shoppinglistexam.repository.ProductRepository;
import com.example.shoppinglistexam.service.CategoryService;
import com.example.shoppinglistexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel,Product.class);
        product.setCategory(categoryService.getCategory(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.getTotalProductsPrice();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoryEnum categoryEnum) {
        return productRepository.findByCategory_Name(categoryEnum).stream().map(product -> {
            ProductViewModel productViewModel = modelMapper.map(product,ProductViewModel.class);
            productViewModel.setId(product.getId());
            return productViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
