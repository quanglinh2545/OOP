<?php

use Illuminate\Database\Seeder;

class LoaisachsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //reset  database
        \App\Models\Loaisach::truncate();

        //create 100 random users
//        factory(\App\Models\Loaisach::class, 10)->create();


        \App\Models\Loaisach::create([
            'id' => '1', 'name' => 'truyện cười', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '2', 'name' => 'truyện trinh thám', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '3', 'name' => 'truyện cổ tích', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '4', 'name' => 'truyện ngụ ngôn', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '5', 'name' => 'sách tâm lý', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '6', 'name' => 'sách giáo dục', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '7', 'name' => 'sách kinh doanh', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '8', 'name' => 'sách cho người già', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '9', 'name' => 'sách cho mẹ và bé', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);
        \App\Models\Loaisach::create([
            'id' => '10', 'name' => 'sách hạt giống tâm hồn', 'created_at' => '2019-02-02', 'updated_at' => '2019-03-02',
        ]);


    }
}
