// Есть набор предметов, у каждого предмета есть: цена и вес.
// Требуется выбрать из заданного набора предметов наиболее ценные, которые поместятся в рюкзак заданной вместимости.

// Алгоритм
// 1. Рассчитываем удельную ценность для каждого предмета.
// 2. Сортируем предметы по убыванию удельной ценности.
// 3. Складываем предметы в рюкзак(массив), по суммарный вес не превысит максимально допустимый


let backpack = [
    {name: "", weight: 0, value: 0},
    {name: "", weight: 0, value: 0},
]


// Алгоритм
// 1. Рассчитываем удельную ценность для каждого предмета.
// 2. Сортируем предметы по убыванию удельной ценности.
// 3. Складываем предметы в рюкзак, пока суммарный вес не превысит максимально допустимый.

let backpack = [
    {name: "Item1", weight: 2, value: 10},
    {name: "Item2", weight: 5, value: 40},
    {name: "Item3", weight: 7, value: 30},
    {name: "Item4", weight: 8, value: 50}
];

let totalWeightCapacity = 10; // Максимальная вместимость рюкзака

// Функция для расчета удельной ценности (цена/вес)
function getValuePerWeight(item) {
    return item.value / item.weight;
}

// Сортируем предметы по убыванию удельной ценности
backpack.sort((a, b) => getValuePerWeight(b) - getValuePerWeight(a));

let totalValue = 0; // Общая стоимость предметов в рюкзаке
let currentWeight = 0; // Текущий вес рюкзака

// Проходим по отсортированным предметам
for (let item of backpack) {
    if (currentWeight + item.weight <= totalWeightCapacity) {
        // Если предмет полностью помещается в рюкзак, добавляем его
        currentWeight += item.weight;
        totalValue += item.value;
    } else {
        // Если предмет не помещается целиком, добавляем его дробную часть
        let remainingWeight = totalWeightCapacity - currentWeight;
        totalValue += item.value * (remainingWeight / item.weight);
        break; // Рюкзак заполнен
    }
}

// Выводим результат
console.log("Общая стоимость предметов в рюкзаке:", totalValue);
