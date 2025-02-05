// В магазине продают только по три и по пять воздушных шариков.
// Можно ли купить ровно k шариков?

// Пример 1:
// Input: 8
// Output: Yes
// Пояснение: Можно купить 5 + 3 шарика

// Пример 2:
// Input: 10
// Output: Yes
// Пояснение: Можно купить 5 + 5 шариков

// Пример 3:
// Input: 7
// Output: No
// Пояснение: Никакими комбинациями 5 и 3, 7 шариков купить невозможно

Решение: 
function canBuyBalloons(k) {
    // Если k меньше 3, то невозможно купить шарики
    if (k < 3) {
        return "No";
    }

    // Если k делится на 5, то можно купить только пятерками
    if (k % 5 === 0) {
        return "Yes";
    }

    // Проверяем, можно ли купить шарики комбинацией 3 и 5
    for (let i = 0; i * 3 <= k; i++) {
        if ((k - i * 3) % 5 === 0) {
            return "Yes";
        }
    }

    return "No";
}

// Примеры использования
console.log(canBuyBalloons(8));  // Output: Yes
console.log(canBuyBalloons(10)); // Output: Yes
console.log(canBuyBalloons(7));  // Output: No
