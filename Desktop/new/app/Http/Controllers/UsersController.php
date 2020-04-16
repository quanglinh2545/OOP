<?php

namespace App\Http\Controllers;

use App\Http\Requests\StoreUserRequest;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Gate;

class UsersController extends Controller
{
    protected $user;

    /**
     * construct class
     *
     * UsersController constructor.
     * @param User $user
     */
    public function __construct(User $user)
    {
        $this->user = $user;
    }

    /**
     * Display a listing of the resource.
     *
     * @param Request $request
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        $users = $this->user->getUsers($request->all());

        return view('users/index')->with('users', $users);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        if (Gate::allows('admin', Auth::user())) {
            return view('users/create');
        }
        flash('Ban khong co quyen truy cap')->error();
        return redirect()->route('users.index');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param \Illuminate\Http\StoreUserRequest $request
     * @return \Illuminate\Http\Response
     */
    public function store(StoreUserRequest $request)
    {
        if (Gate::allows('staff', Auth::user())) {
            flash('Ban khong co du quyen')->error();
            return redirect()->route('users.index');
        }

        $user = $this->user->saveUser($request);

        if ($user != null) {
            //set success message
            flash('add thanh cong')->success();
        }

        return redirect()->route('users.index');
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param int $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        if (Gate::allows('staff', Auth::user())) {
            flash('Ban khong co du quyen')->error();
            return redirect()->route('users.index');
        }

        $user = $this->user->find($id);
        if (!isset($user)) {
            flash('cap nhat that bai')->error();
            return redirect()->route('users.index');
        }

        return view('users/edit')->with('user', $user);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param \Illuminate\Http\StoreUserRequest $request
     * @return \Illuminate\Http\Response
     */
    public function update(StoreUserRequest $request)
    {
        if (Gate::allows('staff', Auth::user())) {
            flash('Ban khong co du quyen')->error();
            return redirect()->route('users.index');
        }

        if ($this->user->updateUser($request)) {
            flash('Cap nhat thanh cong')->success();
        } else {
            flash('Cap nhat that bai')->error();
        }

        return redirect()->route('users.index');
    }

    /**
     * Remove user from storage.
     *
     * @param int $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        if (Gate::allows('staff', Auth::user())) {
            flash('Ban khong co du quyen')->error();
            return redirect()->route('users.index');
        }

        //Check if user exists before deleting
        if ($this->user->deleteUser($id)) {
            flash('Xoa thanh cong')->success();
        } else {
            flash('Xoa that bai')->error();
        }

        return redirect()->route('users.index');
    }
}
