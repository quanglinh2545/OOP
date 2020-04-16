<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="{{ route('books.index') }}">BookBuy</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                {{--                <li class="nav-item active">--}}
                {{--                    <a class="nav-link" href="{{ route('books.index') }}">List Books--}}
                {{--                        <span class="sr-only">(current)</span>--}}
                {{--                    </a>--}}
                {{--                </li>--}}
                @canany(['admin', 'staff'])
                    <li class="nav-item">
                        <a class="nav-link" href="{{ route('books.create') }}">Add Book</a>
                    </li>
                @endcanany
            </ul>

            <ul class="navbar-nav navbar-right">
                @canany(['admin', 'staff'])
                    <li class="nav-item active">
                        <a class="nav-link" href="{{ route('users.index') }}">List Users
                            <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="{{ route('users.create') }}">Add User</a>
                    </li>
                @endcanany

                @guest
                    <li class="nav-item">
                        <a class="nav-link" href="{{ route('login') }}">{{ __('Login') }}</a>
                    </li>
                    @if (Route::has('register'))
                        <li class="nav-item">
                            <a class="nav-link" href="{{ route('register') }}">{{ __('Register') }}</a>
                        </li>
                    @endif
                @else
                    <li class="nav-item dropdown">
                        <a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                            {{ Auth::user()->name }} <span class="caret"></span>
                        </a>

                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="{{ route('home') }}">
                                {{ __('Home') }}
                            </a>

                            <a class="dropdown-item" href="{{ route('logout') }}"
                               onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                {{ __('Logout') }}
                            </a>

                            <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                                @csrf
                            </form>
                        </div>
                    </li>
                @endguest
            </ul>
        </div>
    </nav>
</header>
