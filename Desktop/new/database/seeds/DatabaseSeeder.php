<?php

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        Schema::disableForeignKeyConstraints();

        $this->call(RolesTableSeeder::class);
        $this->call(UsersTableSeeder::class);
        $this->call(LoaisachsTableSeeder::class);
        $this->call(TacgiaTableSeeder::class);
        $this->call(NhaxuatbanTableSeeder::class);
        $this->call(BooksTableSeeder::class);

        Schema::enableForeignKeyConstraints();
    }
}
