import React from 'react'

const Clock = () => {
    return (
        <p>
            It is {new Date().toLocaleTimeString()}.
        </p>
    )
}

export default Clock