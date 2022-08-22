import React, {useState, useEffect} from 'react'
import axios from 'axios'

interface IBookInfo {
    name: string,
    author: string,
    publisher: string,
    publicationDate: Date,
    isbn13: string,
    bookImgPath: string,
}

const GetBookListApiFetch = () => {
    const [bookInfos, setBookInfos] = useState<IBookInfo[]>([])

    useEffect(() => {
        axios.get('http://localhost:8080/biblioApp/book/all')
            .then(res => {
                setBookInfos(res.data)
            })
    }, [])

    return (
        <div>
            <table>
                {bookInfos.map((bookInfo) =>
                    <tr>
                        <td>
                            <img src={bookInfo.bookImgPath.toString()} height="150" alt="書影"/>
                        </td>
                        <td>
                            <div>{bookInfo.name}</div>
                            <div>{bookInfo.author}</div>
                            <div>出版社：{bookInfo.publisher}</div>
                            <div>出版日：{bookInfo.publicationDate.toLocaleString()}</div>
                            <div>ISBN13：{bookInfo.isbn13}</div>
                        </td>
                    </tr>
                )}
            </table>
        </div>
    )
}

export default GetBookListApiFetch;