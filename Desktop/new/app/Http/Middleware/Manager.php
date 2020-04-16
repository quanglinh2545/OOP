<?php

namespace App\Http\Middleware;

use App\Models\User;
use Closure;

class Manager
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        if ($request->user()->role == User::GUESS) {
            return redirect()->route('home');
        }

        return $next($request);
    }
}
