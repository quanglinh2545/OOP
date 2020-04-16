<?php

use Illuminate\Database\Seeder;

class UsersTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //reset  database
        \App\Models\User::truncate();

        //create 100 random users
        factory(\App\Models\User::class, 10)->create();

        \App\Models\User::create([
            'user_name' => 'admin',
            'password' => Hash::make('admin'),
            'name' => 'admin',
            'role' => \App\Models\User::ADMIN,
        ]);
    }
}
