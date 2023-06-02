package trinhquangtan.demo.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import trinhquangtan.demo.Validator.annotation.ValidCategoryId;
import trinhquangtan.demo.enity.Category;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return  category != null && category.getId() != null;
    }
}
