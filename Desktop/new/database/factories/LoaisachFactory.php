<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\Models\Loaisach;
use Faker\Generator as Faker;

$factory->define(Loaisach::class, function (Faker $faker) {
    return [
        'name' => $faker->name   
     ];
});
