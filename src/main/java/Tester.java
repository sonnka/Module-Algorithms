import objects.Person;
import sort.PersonSort;
import sort.UniquePerson;

public class Tester {
    public static void main(String[] args){
        Person[] people = {
                new Person(160,61,28),
                new Person(180,89,36),
                new Person(155,46,18),
                new Person(174,67,28),
                new Person(160,49,43),
                new Person(168,61,24),
                new Person(182,99,41),
                new Person(179,54,18),
                new Person(174,49,47),
                new Person(185,95,20),
                new Person(174,67,19),
                new Person(164,61,44),
                new Person(168,61,24)
        };
        PersonSort personSort = new PersonSort();

        Person[] result = personSort.sortWeight(people);

        for(Person person: result){
            System.out.println(person);
        }

        UniquePerson uniquePerson = new UniquePerson();

        System.out.println(uniquePerson.count(people));
    }
}
/*  1) Для сортування користувачів за віком я використала Radix sort, в якого Big O = O(nk),
    так як в нас не великі цілі числа(максимальна кількість розрядів 3), цей алгоритм
    на мою думку є найбільш підходящим. Таким чином ми можемо забезпечити лінійну складність
    алгоритму по часу.
    2) Для сортування по вазі та зросту, я використовувала той самий алгоритм, що й для
    сортування по зросту.
    3) Склданість мого алгоритма для пошуку кількості користувачів з однаковою вагою та різним
    зростом Big O (для найгіршого випадку) = О(n*n*n),що є максимально затратним по часу алгоритмом.
*/