package com.example.dsvk;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Food> orderedItem;
    private static ArrayList<Food> allDishes;
    private static ArrayList<Food> favDish;



    private Utils(){

        if(null == allDishes){
            allDishes = new ArrayList<>();
            initD();

        }


        if(null == orderedItem){
            orderedItem = new ArrayList<>();
        }

        if(null == favDish){
            favDish = new ArrayList<>();
        }


    }

    public static ArrayList<Food> getAllDishes() {
        return allDishes;
    }

    public static ArrayList<Food> getFavDish() {
        return favDish;
    }

    private void initD() {

        allDishes.add(new Food(1, "VadaPav", "10", "https://gbc-cdn-public-media.azureedge.net/img84619.768x512.jpg", "A plate of vada pav with seasoning of red chilli powder and a green chilli.", false, "1"));
        allDishes.add(new Food(2,"Samosa", "15", "https://thumbs.dreamstime.com/b/samosa-24578861.jpg", "Samosa, a crispy and spicy deep fried snack ", false, "1"));
        allDishes.add(new Food(3, "Veg Biryani", "100","https://www.dishesguru.com/uploads/recipe/veg-biryani-in-pressure-cooker-61442869362-810.jpg", "Vegetable biryani is an aromatic rice dish made by cooking basmati rice with mix veggies, herbs & biryani spices", false, "1"));
        allDishes.add(new Food(4, "Veg Thali", "60", "https://post.healthline.com/wp-content/uploads/2020/07/thali-indian-732x549-thumbnail-732x549.jpg","thali includes rice, bhakri roti (a millet flatbread), bharli vangi (stuffed brinjal), amti (spicy tangy tur lentil), pitla ( thick chickpea flour curry), kothimbir wadi (corainder cutlet), chawli chi usal (black eyed beans curry)", false, "1"));
        allDishes.add(new Food(5, "Mango Lassi", "30","https://www.palatesdesire.com/wp-content/uploads/2020/05/Mango_lassi_recipe@Palates_desire-1536x1025.jpg?ezimgfmt=ng:webp/ngcb3","A mango lassi is basically a yogurt based mango milkshake or smoothie", false, "1"));
        allDishes.add(new Food(6, "Bread Patties", "15", "https://www.sabguru.com/wp-content/uploads/2018/03/Recipe-of-Bread-Patties.jpg", "Bread Pakoda or Bread patties is a crunch bread patties stuffed with spiced Potato filling, coated in seasoned gram flour batter and deep fried", false, "1"));
        allDishes.add(new Food(7, "Veg Sandwich", "40", "https://www.indianhealthyrecipes.com/wp-content/uploads/2019/05/club-sandwich-recipe.jpg", "Delicious toasted veg sandwich with tasty vegetable fillings between the two breads", false, "1"));
        allDishes.add(new Food(8, "Puri Bhaji", "50", "https://cdn.cdnparenting.com/articles/2020/02/26144721/PURI-BHAJI-RECIPE.jpg", "Tasty puri bhaji has 4 pieces of puri served with aaloo matar sabzi", false, "1"));
        allDishes.add(new Food(9, "Sheera", "70", "https://cdn.cdnparenting.com/articles/2020/03/31115816/Wheat-Banana-Sheera-Recipe-696x476.jpg", "Yummy traditional maharastrian sweet dish", false, "1"));
        allDishes.add(new Food(10, "Fries", "100", "https://img.apmcdn.org/4b2716626c9ff3f6e5dfebe520eb592c33cf1e7b/uncropped/b5464d-splendid-table-french-fries.jpg", "An original favourite and the one and only fry you’ll ever need in your life. Fried crisp and golden, each with its own little imperfections so you know they’re fresh, seasonally and locally sourced.", false, "1"));
        allDishes.add(new Food(11,"Nachos", "150", "https://tastykitchen.com/wp-content/uploads/2012/11/Tasty-Kitchen-Blog-Pizza-Nachos.jpg", " An appetizer that traditionally consists of tortilla chips with a melted cheese that is garnished with sliced chile peppers. The cheese can be spread over the chips", false, "1"));
        allDishes.add(new Food(12, "Burger", "200","https://img.jakpost.net/c/2019/11/12/2019_11_12_82229_1573532922._large.jpg", "A hamburger (also burger for short) is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty is pan fried", false, "1"));
        allDishes.add(new Food(13, "Brownies", "160", "https://iambaker.net/wp-content/uploads/2014/06/861A6402.brwonie-650x433.jpg","Our perfect brownie is thick, fudgy, chewy, and chocolaty with a slight hint of gooey goodness. It also has that tissue-thin crinkly crust on top", false, "1"));
        allDishes.add(new Food(14, "Ice Cream", "130","https://www.hpcismart.com/images/website/ManChemTechnical/DIR_20/F_70920.jpg","Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from dairy milk or cream and is flavoured with a sweetener, either sugar or an alternative, and any spice, such as cocoa or vanilla. ", false, "1"));
        allDishes.add(new Food(15, "Tacos", "150", "https://b.zmtcdn.com/data/pictures/9/18975289/dc14117571897f8181d730ee5ed33387.jpg", "A taco is a traditional Mexican dish consisting of a small hand-sized corn or wheat tortilla topped with a filling. The tortilla is then folded around the filling and eaten by hand", false, "1"));
        allDishes.add(new Food(16, "Pav Bhaji", "140", "https://www.cookwithkushi.com/wp-content/uploads/2016/10/IMG_5587_-1.jpg", " Pav bhaji is a popular Indian street food that consists of a spicy mix vegetable mash & soft buns.", false, "1"));
        allDishes.add(new Food(17, "Dosa", "150", "https://sukhis.com/wp-content/uploads/2020/01/Dosa.jpg", "A dosai or dosa or dose is a thin pancake or crepe, originating from South India, made from a fermented batter predominantly consisting of lentils and rice. It is somewhat similar to a crepe in appearance, although savoury flavours are generally emphasized.", false, "1"));
        allDishes.add(new Food(18, "Pasta", "100", "https://www.thespruceeats.com/thmb/JBDSsB1zPFz7-EYDSPpBnG1GVj4=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/pasta-with-garlic-and-cheese-recipe-482004-hero-01-2f4a00f6c39c4f3bb1209eef8b17f9cd.jpg", "The grated Parmesan makes it smell fresh and cheesy. The steam of the pasta dish and the vegetables smell delicious", false, "1"));
       allDishes.add(new Food(19,"Garlic Bread", "150", "https://www.thestatesman.com/wp-content/uploads/2019/11/garlic.jpg", "Garlic bread consists of bread, topped with garlic and olive oil or butter and may include additional herbs, such as oregano or chives. ", false, "1"));
        allDishes.add(new Food(20, "Waffles", "200","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Waffles_with_Strawberries.jpg/800px-Waffles_with_Strawberries.jpg", "A waffle is a dish made from leavened batter or dough that is cooked between two plates that are patterned to give a characteristic size, shape, and surface impression", false, "1"));
        allDishes.add(new Food(21, "Momos", "160", "https://english.mathrubhumi.com/polopoly_fs/1.4598756.1583737451!/image/image.jpg_gen/derivatives/landscape_894_577/image.jpg","Momo is a type of East and South Asian steamed filled dumpling. Momo is native to Nepal, Southwest Tibet, Bhutan as well as Indian Himalayan Region of Ladakh, Sikkim, Assam, and Arunachal Pradesh, and Darjeeling. It is popular across a wider region of the Indian subcontinent", false, "1"));

        //later
    }

    public static Utils getInstance(){
        if (null != instance) {
            return instance;
        }

        else{
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Food> getOrderedItem() {
        return orderedItem;
    }

    public Food getFoodById(int id){
        for(Food f:allDishes){
            if(f.getId()==id){
                return f;
            }
        }
        return null;
    }
    public boolean addToAlreadyFav(Food food){
        return favDish.add(food);
    }
    public boolean addToOrdered(Food food){
        return orderedItem.add(food);
    }
}

