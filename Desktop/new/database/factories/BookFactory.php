<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\Models\Book;
use Faker\Generator as Faker;

$factory->define(Book::class, function (Faker $faker) {
    return [
        'name' => $faker->text(15),
        'desc' => $faker->paragraph,
        'loaisach_id' => \App\Models\Loaisach::all()->pluck('id')->random(),
    ];
});
