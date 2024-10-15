@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Пользователи</h1>
            <form action="/courses" method="get">
				<input type="search" name="term" value="${page.getTerm()}" />
				<input type="submit" value="Search" />
            </form>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
        </div>

    `
)