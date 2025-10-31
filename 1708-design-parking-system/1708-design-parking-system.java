class ParkingSystem {
    int big,med,small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.med = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==3){
            if(small>0){
                small--;
                return true;
            }
            return false;
        }
        else if(carType==2){
            if(med>0){
                med--;
                return true;
            }
            return false;
        }
        else{
            if(big>0){
                big--;
                return true;
            }
            return false;
        }
        //return 
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */