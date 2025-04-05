# Date Class Project

## Project Overview
This Java project implements a `Date` class to handle date-related operations with the following features:
- **Date Validation**: Checks if a date is valid, including leap year handling for February.
- **Date Operations**: Update dates, calculate days between dates, and determine the day of the week.
- **Sorting Support**: Enables sorting of `Date` objects by year, month, and day using `Collections.sort()`.
- **Error Handling**: Provides clear error messages for invalid date inputs.

Key functionalities demonstrated in the `Main` class include:
- Creating valid/invalid date objects.
- Calculating the day of the week for April 6, 2025 (Sunday).
- Computing the day difference between April 6, 2025, and January 1, 2026.
- Sorting a list of dates from 2025.

## How It Works

### 1. Date Validation (`isValidDate()`)
- **Leap Year Check**: Uses the rule `(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)` to determine leap years.
- **Month/Day Validation**:
  - February has 28 days (29 in leap years).
  - Months 4, 6, 9, and 11 have 30 days.
  - All other months have 31 days.
- Example: `29-02-2025` is invalid because 2025 is not a leap year.

### 2. Day of Week Calculation (`getDayOfWeek()`)
- Implements **Zeller's Congruence** algorithm:
  ```java
  int q = day;
  int m = month < 3 ? month + 12 : month;
  int y = month < 3 ? year - 1 : year;
  int h = (q + 13*(m + 1)/5 + y%100 + (y%100)/4 + (y/100)/4 + 5*(y/100)) % 7;
