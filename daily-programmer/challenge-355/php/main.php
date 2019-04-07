<?php

// usage:
// php main.php <secret> <message> <method (e || d)>

function validateArgs($argc, $argv)
{
    // validate args here
    if ($argc === 4 && ($argv[3] === 'e' || $argv[3] === 'd')) {
        // [ $secret, $message, $method ]
        return [$argv[1], $argv[2], $argv[3]];
    } else {
        echo "Usage:\nphp main.php <secret> <message> <method (e || d)>\n\n";
        exit("Invalid number of arguments passed.\n");
    }
}

function encrypt($secret, $message)
{

    /*
     *
     *   This works off of offsets of 'a' (ASCII Value: 97) in the ASCII table.
     *
     *   Ex: 'l' => 108 ASCII
     *          108 - 97 = 11
     *          Offset of 'l' in relation to 'a' is: 11
     *
     *      For each pairing of ASCII values, this is done at the same time, thus:
     *          ('s' => 115) + ('t' => 116) = 231
     *          231 - (97 + 97) = 231 - 194 = 37
     *
     *      Then we find our true offset in relation to a 26-letter English alphabet:
     *          37 % 26 = 11
     *
     *      So our offset from 'a' is 13:
     *          ('a' => 97) + 11 = 108
     *
     *      Finally, we get our desired encrypted output:
     *          chr(108) => 'l'
     *
    */

    $encrypted = "";
    for ($i = 0; $i < strlen($message); $i++) {
        $encrypted .= chr(((ord($message[$i]) + ord($secret[$i % strlen($secret)]) - 194) % 26) + 97);
    }

    return $encrypted;
}

function decrypt($secret, $message)
{
    // TODO: Implement decrypt function
    $decrypted = "Decrypt not yet implemented :(";

    return $decrypted;
}

function main($argc, $argv)
{
    $args    = validateArgs($argc, $argv);
    $secret  = strtolower($args[0]);
    $message = strtolower($args[1]);
    $method  = strtolower($args[2]);

    switch ($method) {
        case 'e':
            $output = encrypt($secret, $message);
            break;
        case 'd':
            $output = decrypt($secret, $message);
            break;
    }

    echo $output . "\n";
}

main($argc, $argv);
