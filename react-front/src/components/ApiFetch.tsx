import React, {useState, useEffect} from 'react'
import axios from 'axios'

interface IBook {
    name: String,
    author: String,
    publisher: String,
    publicationDate: Date,
    isbn13: String,
    bookImgPath: String,
}

const ApiFetch = () => {
    const [posts, setPosts] = useState<IBook[]>([])

    useEffect(() => {
        axios.get('http://localhost:8080/biblioApp/book/all')
            .then(res => {
                setPosts(res.data)
            })
    }, [])

    return (
        <div>
            <table>
                {posts.map((post) =>
                    <tr>
                        <td>
                            <img src={post.bookImgPath.toString()} height="150" alt="書影"/>
                        </td>
                        <td>
                            <div>{post.name}</div>
                            <div>{post.author}</div>
                            <div>出版社：{post.publisher}</div>
                            <div>出版日：{post.publicationDate.toLocaleString()}</div>
                            <div>ISBN13：{post.isbn13}</div>
                        </td>
                    </tr>
                )}
            </table>
        </div>
    )
}

export default ApiFetch