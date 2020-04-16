<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\Models\tacgia;
use Faker\Generator as Faker;

$factory->define(Tacgia::class, function (Faker $faker) {
    return [
		'name' => $faker->unique()->name,
		'email' => $faker->unique()->safeEmail,
		'phone' => $faker->phoneNumber,
		'address' => $faker->address
    ];
});
