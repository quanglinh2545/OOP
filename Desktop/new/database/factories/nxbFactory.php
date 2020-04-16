<?php
/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\Models\Nhaxuatban;
use Faker\Generator as Faker;

$factory->define(Nhaxuatban::class, function (Faker $faker) {
    return [
        'ten' => $faker->unique()->name,
        'diachi' => $faker->address,
        'sdt' => $faker->unique()->phoneNumber,
        'email' => $faker->unique()->safeEmail,
        'website' => $faker->unique()->name
    ];
});
