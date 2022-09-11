package sort;

import objects.Person;

public class PersonSort {

    public Person[] sortAge(Person[] people){
        int valueType = 1;
        return sort(people, valueType);
    }

    public Person[] sortHeight(Person[] people){
        int valueType = 2;
        return sort(people, valueType);
    }
    public Person[] sortWeight(Person[] people){
        int valueType = 3;
        return sort(people, valueType);
    }
    private Person[] sort(Person[] people, int valueType){
        int maxElement = findMaxValue(people, valueType);
        int maxRadix = findMaxRadix(maxElement);
        int grade = 1;
        for(int i = 0; i < maxRadix; i++){
            countingSort(people,grade, valueType);
            grade *= 10;
        }
        return people;
    }
    private int value(Person[] people, int index, int valueType){
        if(index < people.length){
            if(valueType == 1)
                return people[index].getAge();
            if(valueType == 2)
                return people[index].getHeight();
            if(valueType == 3)
                return people[index].getWeight();
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return -1;
    }
    private int findMaxValue(Person[] people, int valueType){
        int max = value(people,0, valueType);
        for(int i = 1 ; i < people.length; i++){
            max = Math.max(max, value(people,i, valueType));
        }
        return max;
    }
    private int findMaxRadix(int maxElement){
        int r = 1;
        while(maxElement > 10){
            maxElement /= 10;
            r++;
        }
        return r;
    }
    private void countingSort(Person[] people, int grade, int valueType){
        int range = 10;
        int n=people.length;
        Person[] result = new Person[n];
        int[] count = new int[range];

        for (int i =0; i<n; i++) {
            int digit = (value(people,i, valueType)/grade) % range;
            count[digit]++;
        }

        for(int i=1; i<range; i++) {
            count[i] = count[i-1] + count[i];
        }

        for(int i=n-1; i>=0; i--) {
            int digit =  (value(people,i, valueType) /grade) % range;
            int position = count[digit];
            result[position -1] = people[i];
            count[digit]--;
        }

        for(int i =0; i<n; i++) {
            people[i] = result[i];
        }
    }
}
