public class Machine {
    
    private Item[][] items;

    public Machine(){
        items = new Item[3][3];
    }

    public void setItems(Item items, int row, int spot) {
        this.items[row][spot] = new Item(items);
    }

    public Item getItems(int row, int spot) {
        return new Item(items[row][spot]);
    }
    
    public Boolean dispense(int row, int spot){
        int quantity = items[row][spot].getQuantity();
        if(quantity>0){
            items[row][spot].setQuantity(quantity-1);
            return true;
        }
        return false;

    }

    public String toString(){
        String temp = "\n";
        for (int i = 0; i < items.length; i++) {
            temp+="\t";
            for (int j = 0; j < items[i].length; j++) {
                temp=temp+items[i][j].getName()+": "+items[i][j].getPrice()+" ("+items[i][j].getQuantity()+") ";
            }
            temp=temp+"\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }

}
