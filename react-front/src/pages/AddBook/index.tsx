import {Box, Button, TextField} from "@mui/material";
import SendIcon from '@mui/icons-material/Send';
import {useState} from "react";
import axios from "axios";

interface IBookInfo {
    name: string,
    author: string,
    publisher: string,
    publicationDate: string,
    isbn13: string,
    bookImgPath: string,
}

const AddBook = () => {
    const [isbn13, setIsbn13] = useState('')
    const [name, setName] = useState('')
    const [author, setAuthor] = useState('')
    const [publisher, setPublisher] = useState('')
    const [publicationDate, setPublicationDate] = useState('')
    const [bookInfos, setBookInfos] = useState<IBookInfo[]>([])

    const handleSubmit = () => {
        const data = {
            name: name,
            author: author,
            publisher: publisher,
            publicationDate: publicationDate,
            isbn13: isbn13
        }

        console.log(data.publicationDate)

        axios.post('http://localhost:8080/biblioApp/book/add', data)
            .then(res => {
                setBookInfos(res.data)
            })
            .catch(function (error) {
                // 送信失敗時の処理
                console.log(error);
            });
    }

    return (
        <div>
            <h1>本の登録</h1>
            <Box
                component="form"
                sx={{'& > :not(style)': { m: 1, width: '50ch' },}}
                noValidate
                autoComplete="off">
                <div><TextField
                    required fullWidth
                    id="isbn13"
                    label="ISBN13"
                    variant="standard"
                    onChange={(event) => setIsbn13(event.target.value)} /></div>
                <div><TextField
                    required fullWidth
                    id="bookName"
                    label="本の題名"
                    variant="standard"
                    onChange={(event) => setName(event.target.value)} /></div>
                <div><TextField
                    required fullWidth
                    id="author"
                    label="著者名"
                    variant="standard"
                    onChange={(event) => setAuthor(event.target.value)} /></div>
                <div><TextField
                    required fullWidth
                    id="publisher"
                    label="出版社"
                    variant="standard"
                    onChange={(event) => setPublisher(event.target.value)} /></div>
                <div><TextField
                    required fullWidth
                    id="publicationDate"
                    label="出版日"
                    variant="standard"
                    onChange={(event) => setPublicationDate(event.target.value)} /></div>
                <br />
                <div style={{textAlign: "center"}}>
                    <Button
                        size={"small"}
                        fullWidth
                        variant="contained"
                        endIcon={<SendIcon />}
                        onClick={handleSubmit}>Send</Button>
                </div>

            </Box>
        </div>
    )
}

export default AddBook;