<?php

function validateInput($input, $scores)
{
    // checks to see if each character in input is in the
    // scores array as lowercase character, fails program if not
    for ($i = 0; $i < strlen($input); $i++) {
        if (!(array_key_exists(strtolower($input[$i]), $scores))) {
            exit("Invalid input.\n");
        }
    }
    return true;
}

function validateArgs($argc, $argv)
{
    if ($argc < 2) {
        exit("Supplied input is invalid.\n");
    }
    return $argv[1];
}

function main($argc, $argv)
{
    $input  = validateArgs($argc, $argv);
    $scores = [
        'a' => 0,
        'b' => 0,
        'c' => 0,
        'd' => 0,
        'e' => 0
    ];

    if (validateInput($input, $scores)) {
        // input safe, proceed
        for ($i = 0; $i < strlen($input); $i++) {
            if (ord($input[$i]) >= 65 && ord($input[$i]) <= 69) {
                // capital letter, decrease value
                $scores[strtolower($input[$i])] -= 1;
            } else {
                // lowercase letter, increase value
                $scores[strtolower($input[$i])] += 1;
            }
        }
    }

    // sort in descending order
    arsort($scores);

    // display output
    foreach ($scores as $key => $value) {
        echo "{$key}: {$value}\n";
    }
}

main($argc, $argv);
