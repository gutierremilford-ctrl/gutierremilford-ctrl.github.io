const display = document.getElementById('display');

// Adds numbers or operators to the screen
function appendValue(input) {
    if (display.value === "Error") {
        display.value = "";
    }
    display.value += input;
}

// Completely clears the screen
function clearDisplay() {
    display.value = "";
}

// Deletes the very last character entered
function deleteLast() {
    display.value = display.value.slice(0, -1);
}

// Does the math logic safely
function calculateResult() {
    try {
        // eval calculates the string (e.g., "7*2+5") directly
        if (display.value) {
            display.value = eval(display.value);
        }
    } catch (error) {
        display.value = "Error"; // Displays if they type broken math like "7++2"
    }
}