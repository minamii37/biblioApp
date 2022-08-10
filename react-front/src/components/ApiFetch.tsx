import React, {useState, useEffect} from 'react'
import axios from 'axios'

interface IPost {
    name: String
}

const ApiFetch = () => {
    const [posts, setPosts] = useState<IPost[]>([])

    useEffect(() => {
        axios.get('http://localhost:8080/biblioApp/book/all')
            .then(res => {
                setPosts(res.data)
            })
    }, [])

    return (
        <div>
            <ul>
                {
                    posts.map(post => <li> {post.name} </li>)
                }
            </ul>

        </div>
    )
}

export default ApiFetch