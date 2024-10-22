@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Posts</h1>
            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            ${post.getName()}
                        </td>
                        <td>
							${post.getBody()}
						</td>
                    </tr>
                @endfor
            </table>
        </main>
        </div>

    `
)