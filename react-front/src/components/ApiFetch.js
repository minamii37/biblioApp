import React, {useState, useEffect} from 'react'
import axios from 'axios'

const ApiFetch = () => {

    const [posts, setPosts] = useState([])

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
                    posts.map(post => <li key={post.name}> {post.name} </li>)
                }
            </ul>

        </div>
    )
}

export default ApiFetch