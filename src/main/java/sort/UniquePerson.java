package sort;

import objects.Person;

import java.util.ArrayList;
import java.util.List;

public class UniquePerson {

    public int count(Person[] people){
        int count = 0;
        List<Person> temp = new ArrayList<>();
        PersonSort personSort = new PersonSort();
        people = personSort.sortWeight(people);
        for(int i = 0; i < people.length-1; i++){
            while(i < people.length-1 && people[i].getWeight() == people[i+1].getWeight()) {
                temp.add(people[i]);
                i++;
                if (people[i - 1].getHeight() != people[i].getHeight()) {
                    temp.add(people[i]);
                }
            }
            deleteDuplicate(temp);
            count+=temp.size();
            temp.clear();
        }
        return count;
    }
    private List<Person> deleteDuplicate(List<Person> temp){
        for(int i = 0 ; i < temp.size()-1; i++){
            for(int j = i+1 ; j < temp.size(); j++){
                if(temp.get(i).getHeight() == temp.get(j).getHeight()){
                    temp.remove(j);
                    i = 0;
                }
            }
        }
        return temp;
    }
}

