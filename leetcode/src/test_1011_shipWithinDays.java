/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * @author Shenhan
 * @create 2021-04-26-14:24
 */
public class test_1011_shipWithinDays {

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int i = shipWithinDays(weights, D);
        System.out.println(i);


    }



    public static int shipWithinDays(int[] weights, int D) {
        //使用二分法
        int sum = 0;
        int maxWeight = weights[0];
        for (int weight : weights) {
            sum += weight;
            maxWeight = Math.max(weight,maxWeight);
        }
        int average = sum / D;
        int left = Math.max(average,maxWeight);
        int right = sum;

        while (left < right){
            int mid = left+right >> 1;
            int days = 1;
            int dayWeights = 0;
            for (int weight : weights) {
                if (dayWeights+weight <= mid){
                    dayWeights += weight;
                }else {
                    days++;
                    dayWeights = weight;
                }
            }
            if (days <= D){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;

        /*
        //求平均值，找最大值; 进行一个循环枚举尝试
        //效率太低
        int sum = 0;
        int maxWeight = weights[0];
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxWeight = weights[i] > maxWeight ? weights[i] : maxWeight;
        }
        int average = sum / D;
        maxWeight = maxWeight > average ? maxWeight : average;
        boolean flag = true;
        while (flag) {
            int i = 0,j = 0;
            int[] dayWeights = new int[D];
            while (i < D && j < weights.length){
                do {
                    dayWeights[i] += weights[j];
                    j++;
                }while (j < weights.length && dayWeights[i] + weights[j] <= maxWeight);
                i++;
            }
            if (j == weights.length){
                flag = false;
            }else {
                maxWeight++;
            }
        }

        return maxWeight;
        */
    }

}
