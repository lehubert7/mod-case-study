import React, {Component} from 'react';
import $ from 'jquery';
import {connect} from 'react-redux';
import { Redirect } from 'react-router'
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import Header from '../Header/Header.js';
import SearchTrainings from '../SearchTrainings/SearchTrainings.js';
import CurrentTrainings from '../CurrentTrainings/CurrentTrainings.js';
import CompletedTrainings from '../CompletedTrainings/CompletedTrainings.js';

function mapStateToProps(state, props) {
    return {
      userId: state.userId
    };
}

class Scholar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      redirect: {
        flag: false,
        path: '/login'
      }
    };
    if(!this.props.userId) {
      this.state.redirect.flag = true;
    }
  }

  componentDidMount() {
  }

  componentDidUpdate() {
  }

  render() {
    const {redirect} = this.state;
    if(redirect.flag) {
      return (<Redirect to={redirect.path}/>);
    }
    return (
      <div class="scholar-container">
        <Header/>
        <div class="tabs-container">
          <Tabs>
            <TabList>
              <Tab>Current Trainings</Tab>
              <Tab>Search Trainings</Tab>
              <Tab>Completed Trainings</Tab>
              <Tab>Notifications</Tab>
            </TabList>

            <TabPanel>
              <CurrentTrainings/>
            </TabPanel>
            <TabPanel>
              <SearchTrainings/>
            </TabPanel>
            <TabPanel>
              <CompletedTrainings/>
            </TabPanel>
            <TabPanel>
              <h5>Notifications</h5>
            </TabPanel>
          </Tabs>
        </div>
      </div>
    );
  }
}
export default connect(mapStateToProps)(Scholar);
