<?php

use Illuminate\Database\Seeder;

class TacgiaTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //
		\App\Models\tacgia::truncate();
		factory(\App\Models\tacgia::class, 10)->create();
    }
}
