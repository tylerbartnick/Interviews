<?php

function getOffsets(int $number)
{
    $offsets = [];

    while ($number > 0) {
        $offsets[] = $number % 62;
        $number    = (int) ($number / 62);
    }

    return array_reverse($offsets);
}

function main($argc, $argv)
{
    if ($argc < 2) { exit("Usage:\n\$ php main.php <base10_number>\n"); }
    if (!is_numeric($argv[1])) { exit("Invalid argument: {$argv[1]}. Must be numeric.\n"); }

    $alphabet     = str_split('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');
    $offsets      = getOffsets($argv[1]);
    $base62string = '';

    foreach ($offsets as $offset) {
        $base62string .= $alphabet[$offset];
    }

    echo $base62string . "\n";
}

main($argc, $argv);
