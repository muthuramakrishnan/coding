class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] carArr = new Car[n];
        for(int i=0; i<n; i++){
            carArr[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(carArr);
        int fleet = 0;
        double time1 = -1D;
        for(int i=0; i<n; i++){
            int diffDist = target - carArr[i].getPosition();
            double time2 = (double) diffDist / carArr[i].getSpeed();
            if(time2 > time1){
                fleet++;
                time1 = time2;
            }
        }
        return fleet;
    }
}

class Car implements Comparable<Car>{
    int position;
    int speed;
    Car(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
    public int getPosition(){
        return this.position;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int compareTo(Car obj){
        return obj.position - this.position;
    }
}