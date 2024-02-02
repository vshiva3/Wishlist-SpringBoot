package com.shivaprasad.wishlist.customconstraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String>{

    String[] categories = {"Groceries","Electronics","Fashion","Medicines"};
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        for(int i=0;i<categories.length;i++){
            if(value.equals(categories[i])){
                return true;
            }
        }
        return false;
    }
}
