package sg.nus.iss.miniproject69.models;


import java.io.StringReader;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class ItemModel { //set up model for use in services 
    
    private String itemName;
    private String itemSerialNumber;
    private String itemDescription;
    private String itemPrice;
    private boolean isHalal;
    private String itemCategory;
    private String itemBrand;
    private String itemDiscount;

    
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemSerialNumber() {
        return itemSerialNumber;
    }
    public void setItemSerialNumber(String itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public String getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    public boolean isHalal() {
        return isHalal;
    }
    public void setHalal(boolean isHalal) {
        this.isHalal = isHalal;
    }
    public String getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
    public String getItemBrand() {
        return itemBrand;
    }
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }
    public String getItemDiscount() {
        return itemDiscount;
    }
    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }


  public static ItemModel create(JsonObject json) { //convert to json object 

        final ItemModel Items = new ItemModel();
        Items.setHalal(json.getBoolean("halal"));
        Items.setItemBrand(json.getString("brand"));
        Items.setItemCategory(json.getString("category"));
        Items.setItemDescription(json.getString("description"));
        Items.setItemDiscount(json.getString("discount"));
        Items.setItemName(json.getString("name"));
        Items.setItemPrice(json.getString("price"));
        Items.setItemSerialNumber(json.getString("serial_no"));

        return Items;
    }

    public static ItemModel create(String json){ 
        try(StringReader stringReader = new StringReader(json)){
            JsonReader jsonReader = Json.createReader(stringReader);
            return create(jsonReader.readObject());
        }

    }
    public JsonObject toJson(){
        return Json.createObjectBuilder()
                .add("name", this.itemName)
                .add("halal", this.isHalal())
                .add("brand", this.itemBrand)
                .add("category", itemCategory)
                .add("descripyion", itemDescription)
                .add("discount", itemDiscount)
                .add("price", itemPrice)
                .add("serial_no", itemSerialNumber)
                .build();
    }
    

}
