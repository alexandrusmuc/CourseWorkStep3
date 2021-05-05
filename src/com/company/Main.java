package com.company;



public class Main {
    public static BinarySearchTree petTree = new BinarySearchTree();
    public static void main(String[] args) {



        String petType;
        String option;
        do {
            System.out.println("0: quit");
            System.out.println("1: add new pet Type");//done
            System.out.println("2: add details of a new Product");//done
            System.out.println("3: Find if the company stocks products for a particular pet");//done????
            System.out.println("4: display all the types of pets that the company provides products for");///later
            System.out.println("5: display all the products for a specific type");//done
            System.out.println("6: display all the product details for all the pets ");///done
            System.out.println("7: remove a particular product for a specified pet type");//
            System.out.println("8: remove a pet type from the system");//
            option = Input.getString("option: ").trim();
            switch (option) {
                case "0":
                    System.out.println("quitting program");
                    break;
                case "1": //add new Pet Type
                    petType = Input.getString("Pet Type : ");
                    try {
                        petTree.insert(new Pet(petType));
                        System.out.println("inserted");
                    } catch (SortedADT.NotUniqueException e) {
                        System.out.println("insert invalid - pet type  not unique");
                    }
                    Input.getString("Press enter to continue....");
                    break;
                case "2": //add new Product
                    addProduct();
                    Input.getString("Press enter to continue....");
                    break;
                case "3":
                    String name  = Input.getString("Type in the type of pet: ");
                    try{
                        Pet  pet = (Pet) petTree.find(new Pet(name));
                        if (pet.getProducts().isEmpty()){
                            System.out.println("There are no products for this type of pet at the moment ");
                        }else{
                            System.out.println("The company does stock products for pet type: "+ name);
                        }

                    }catch (SortedADT.NotFoundException e){
                        System.out.println("there is no stock for such a pet type");
                    }
                    Input.getString("Press enter to continue....");
                    break;
                case "4":
                    petTree.displayPetInOrder();
                    Input.getString("Press enter to continue....");
                    break;
                case "5":
                    displayProductsForSpecificType();
                    Input.getString("Press enter to continue....");
                    break;
                case "6":
                    System.out.println(petTree.getInOrder());
                    Input.getString("Press enter to continue....");
                    break;
                case "7":
                    removeProduct();
                    Input.getString("Press enter to continue....");
                    break;
                case "8":
                    removePetType();
                    Input.getString("Press enter to continue....");

                    break;

                default:
                    System.out.println("invalid option");
            }
        } while (!option.equals("0"));
    }


    public static void addProduct(){
        String petType = Input.getString("What pet type is the product for?: ");

        Pet pet;
        try{
            pet = (Pet) petTree.find(new Pet(petType));
        }catch(SortedADT.NotFoundException e){
            System.out.println("pet type does not exist!!");
            return;
        }
        String productCode = Input.getString("Type in product code:  ");
        String productName = Input.getString("Type in product name: ");
        int stock = Input.getInteger("Type in amount in stock: ");
        try{
            pet.getProducts().insert(new Product(productCode, productName,stock));
            System.out.println(productName + " successfully added to pet type: " + pet.getPetType() );
        }catch (SortedADT.NotUniqueException e){
            System.out.println("Such a product Already exists!!");
        }
    }

    public static void displayProductsForSpecificType(){
        String petType = Input.getString("Type in the type of pet: ");

        try{
            Pet pet = (Pet) petTree.find(new Pet(petType));
            System.out.println(pet);
        }catch (SortedADT.NotFoundException e){
            System.out.println("No such type of pet");
        }
    }
    public static void removeProduct(){
        String petType = Input.getString("Type in the type of pet: ");

        try{
            Pet pet =(Pet) petTree.find(new Pet(petType));
            SortedLinkedList products = pet.getProducts();
            String productName = Input.getString("Type in the product you want to remove: ").trim();
            try{
                products.remove(new Product(" " , productName,1));
                System.out.println(productName + "  has been successfully removed from stock!");

            }catch (SortedADT.NotFoundException e){
                System.out.println("There is no such product in stock!!");
            }


        }catch (SortedADT.NotFoundException e){
            System.out.println("There is no such pet type in the system!!");
        }
    }

    public static void removePetType(){
        String petType = Input.getString("Type in the type of pet: ");
        try{
            petTree.remove(new Pet(petType));
            System.out.println(petType + " has been successfully removed from system!");
        }catch (SortedADT.NotFoundException e){
            System.out.println("Such pet type does not exist in the system!!");
        }
    }

}


