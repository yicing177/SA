<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth', 'verified'])->name('dashboard');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});
Route::get('/combo', function () {
    return view('comboMeal'); // 指向 resources/views/comboMeal.blade.php
});
Route::get('/aLaCarte', function () {
    return view('aLaCarte'); // 指向 resources/views/caLaCarte.blade.php
});
require __DIR__ . '/auth.php';
