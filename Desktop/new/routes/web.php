<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});
Route::get('/app', function () {
    return view('app');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::resource('/users', 'UsersController')->middleware(['auth', 'manager']);

Route::resource('/books', 'BooksController');

Route::resource('/loaisachs', 'LoaisachsController');
Route::resource('/nhaxuatbans', 'NhaxuatbansController');
Route::resource('/tacgias', 'TacgiasController');

Route::get('test', function () {
    return view('exam.index');
});
