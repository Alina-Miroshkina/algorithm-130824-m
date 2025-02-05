// Даны две строки.
// Проверить, являются ли они анаграммами (состоят из одних и тех же букв, но в разном порядке).

Решение: 
// Функция для проверки, являются ли две строки анаграммами
function areAnagrams(str1, str2) {
    // Удаляем пробелы и приводим строки к нижнему регистру
    str1 = str1.replace(/\s+/g, '').toLowerCase();
    str2 = str2.replace(/\s+/g, '').toLowerCase();

    // Если длины строк не равны, они не могут быть анаграммами
    if (str1.length !== str2.length) {
        return false;
    }

    // Сортируем строки и сравниваем их
    return str1.split('').sort().join('') === str2.split('').sort().join('');
}

// Пример использования
const str1 = "listen";
const str2 = "silent";

if (areAnagrams(str1, str2)) {
    console.log(`"${str1}" и "${str2}" являются анаграммами.`);
} else {
    console.log(`"${str1}" и "${str2}" не являются анаграммами.`);
}
