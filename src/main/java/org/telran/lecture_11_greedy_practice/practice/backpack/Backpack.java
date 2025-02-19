package org.telran.lecture_11_greedy_practice.practice.backpack;

// Есть набор предметов, у каждого предмета есть: цена и вес.
// Требуется выбрать из заданного набора предметов наиболее ценные, которые поместятся в рюкзак заданной вместимости.

// Алгоритм
// 1. Рассчитываем удельную ценность для каждого предмета.
// 2. Сортируем предметы по убыванию удельной ценности.
// 3. Складываем предметы в рюкзак(массив), по суммарный вес не превысит максимально допустимый

public class Backpack {
    public static void main(String[] args) {
        Item[] items = new Item[]{ // Исходный набор предметов
                new Item(),
                new Item(),
        };
        int totalWeight = 10; // Максимальная вместимость рюкзака
    }

}
Решение : 
package org.telran.lecture_11_greedy_practice.practice.backpack;

import java.util.Arrays;
import java.util.Comparator;

// Класс для решения задачи о рюкзаке с использованием жадного алгоритма
public class Backpack {
    public static void main(String[] args) {
        // Исходный набор предметов
        Item[] items = new Item[]{
            new Item("Item1", 10, 2), // Цена 10, вес 2
            new Item("Item2", 40, 5), // Цена 40, вес 5
            new Item("Item3", 30, 7), // Цена 30, вес 7
            new Item("Item4", 50, 8)  // Цена 50, вес 8
        };

        int totalWeight = 10; // Максимальная вместимость рюкзака

        // Решение задачи о рюкзаке
        solveKnapsack(items, totalWeight);
    }

    // Метод для решения задачи о рюкзаке
    public static void solveKnapsack(Item[] items, int totalWeight) {
        // Сортируем предметы по убыванию удельной ценности (цена/вес)
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> -item.getValuePerWeight()));

        double totalValue = 0; // Общая стоимость предметов в рюкзаке
        double currentWeight = 0; // Текущий вес рюкзака

        // Проходим по отсортированным предметам
        for (Item item : items) {
            if (currentWeight + item.weight <= totalWeight) {
                // Если предмет полностью помещается в рюкзак, добавляем его
                currentWeight += item.weight;
                totalValue += item.price;
            } else {
                // Если предмет не помещается целиком, добавляем его дробную часть
                int remainingWeight = totalWeight - currentWeight;
                totalValue += item.price * ((double) remainingWeight / item.weight);
                break; // Рюкзак заполнен
            }
        }

        // Выводим результат
        System.out.println("Общая стоимость предметов в рюкзаке: " + totalValue);
    }
}

// Класс, представляющий предмет с ценой и весом
class Item {
    String name;
    int price;
    int weight;

    // Конструктор для инициализации объекта Item
    Item(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    // Метод для расчета удельной ценности (цена/вес)
    public double getValuePerWeight() {
        return (double) price / weight;
    }
}
