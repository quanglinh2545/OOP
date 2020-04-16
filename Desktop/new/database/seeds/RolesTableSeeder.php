<?php

use Illuminate\Database\Seeder;

class RolesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        \App\Models\Role::truncate();

        \App\Models\Role::create([
            'id'=>'1','name'=>'ADMIN','created_at'=>'2019-02-02','updated_at'=>'2019-03-02',
        ]);

        \App\Models\Role::create([
            'id'=>'2','name'=>'STAFF','created_at'=>'2019-02-02','updated_at'=>'2019-03-02',
        ]);

        \App\Models\Role::create([
            'id'=>'3','name'=>'GUESS','created_at'=>'2019-02-02','updated_at'=>'2019-03-02',
        ]);

    }
}
