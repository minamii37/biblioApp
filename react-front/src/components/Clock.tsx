import React from 'react';

interface IAppProps {
}
interface IAppState {
    date: Date;
}

class Clock extends React.Component<IAppProps, IAppState>  {
    private timerID: NodeJS.Timer | undefined;
    constructor(props: IAppProps) {
        super(props);
        this.state = { date: new Date() };
    }

    componentDidMount() {
        this.timerID = setInterval(
            () => this.tick(),
            1000
        );
    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    tick() {
        this.setState({
            date: new Date()
        });
    }

    render() {
        return (
            <div>
                It is {this.state.date.toLocaleTimeString()}.
            </div>
        );
    }
}

export default Clock