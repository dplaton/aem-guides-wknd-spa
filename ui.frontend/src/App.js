import {Page, withModel} from '@adobe/aem-react-editable-components';
import React from 'react';

// This component is the application entry point
class App extends Page {
    render() {
        console.log(`Do we have components?`, this.childComponents);
        return (
            <div>
                {this.childComponents}
                {this.childPages}
            </div>
        );
    }
}

export default withModel(App);
