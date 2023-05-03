
public class QLearningExample {

    public void run() {
        
        Environment environment = new MyEnvironment();
        ActionSpace actionSpace = new MyActionSpace();

        
        QLearning agent = QLearningFactory.create(environment, actionSpace);

        
        for (int i = 0; i < 10000; i++) {
            State state = environment.getInitialState();
            while (!environment.isTerminal(state)) {
                int action = agent.chooseAction(state);
                State nextState = environment.step(state, action);
                double reward = environment.getReward(state, action, nextState);
                agent.learn(state, action, nextState, reward);
                state = nextState;
            }
        }
    }
}

