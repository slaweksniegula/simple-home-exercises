package exercises.mediumExercises.frigde;

public class Product {
    public String nameOfProduct;
    public int calorie;
    public Product(String nameOfProduct, int calorie) {
        this.nameOfProduct = nameOfProduct;
        this.calorie = calorie;
    }

    public int getCalorie() {
        return calorie;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return nameOfProduct != null ? nameOfProduct.equals(product.nameOfProduct) : product.nameOfProduct == null;
    }

    @Override
    public int hashCode() {
        return nameOfProduct != null ? nameOfProduct.hashCode() : 0;
    }
}
