package com.pinganfu.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class BlacklistStore extends Contract {
    private static final String BINARY = "60806040526100133361001860201b60201c565b61003a565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b6104e7806100496000396000f3fe608060405234801561001057600080fd5b50600436106100875760003560e01c8063ac7475ed1161005b578063ac7475ed146100ee578063dbac26e914610114578063e30c39781461014c578063f2fde38b1461015457610087565b8062dc4cf71461008c5780634e71e0c8146100ba578063570ca735146100c25780638da5cb5b146100e6575b600080fd5b6100b8600480360360408110156100a257600080fd5b506001600160a01b03813516906020013561017a565b005b6100b86101f8565b6100ca6102a8565b604080516001600160a01b039092168252519081900360200190f35b6100ca6102b7565b6100b86004803603602081101561010457600080fd5b50356001600160a01b03166102c6565b61013a6004803603602081101561012a57600080fd5b50356001600160a01b03166103c0565b60408051918252519081900360200190f35b6100ca6103d2565b6100b86004803603602081101561016a57600080fd5b50356001600160a01b03166103e1565b6002546001600160a01b031633146101dc5760408051600160e51b62461bcd02815260206004820152601d60248201527f6d73672e73656e6465722073686f756c64206265206f70657261746f72000000604482015290519081900360640190fd5b6001600160a01b03909116600090815260036020526040902055565b6001546001600160a01b0316331461024457604051600160e51b62461bcd0281526004018080602001828103825260258152602001806104666025913960400191505060405180910390fd5b600154600080546040516001600160a01b0393841693909116917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360018054600080546001600160a01b03199081166001600160a01b03841617909155169055565b6002546001600160a01b031690565b6000546001600160a01b031690565b6000546001600160a01b031633146103285760408051600160e51b62461bcd02815260206004820152601a60248201527f6d73672e73656e6465722073686f756c64206265206f776e6572000000000000604482015290519081900360640190fd5b6001600160a01b03811661037057604051600160e51b62461bcd02815260040180806020018281038252603181526020018061048b6031913960400191505060405180910390fd5b600280546001600160a01b0319166001600160a01b0383811691909117918290556040519116907f4721129e0e676ed6a92909bb24e853ccdd63ad72280cc2e974e38e480e0e6e5490600090a250565b60036020526000908152604090205481565b6001546001600160a01b031690565b6000546001600160a01b031633146104435760408051600160e51b62461bcd02815260206004820152601a60248201527f6d73672e73656e6465722073686f756c64206265206f776e6572000000000000604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b039290921691909117905556fe6d73672e73656e6465722073686f756c64206265206f6e6c7950656e64696e674f776e657243616e6e6f74206368616e676520746865206e65774f70657261746f7220746f20746865207a65726f2061646472657373a165627a7a72305820b540dd4a5f60542fbad022c72d987264f26beebc348c7db217fa11b2d517f9790029";

    public static final String FUNC_SETBLACKLIST = "setBlacklist";

    public static final String FUNC_CLAIMOWNERSHIP = "claimOwnership";

    public static final String FUNC_OPERATOR = "operator";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_UPDATEOPERATOR = "updateOperator";

    public static final String FUNC_BLACKLISTED = "blacklisted";

    public static final String FUNC_PENDINGOWNER = "pendingOwner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event OPERATORCHANGED_EVENT = new Event("OperatorChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected BlacklistStore(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BlacklistStore(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BlacklistStore(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BlacklistStore(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> setBlacklist(String _account, BigInteger _status) {
        final Function function = new Function(
                FUNC_SETBLACKLIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_account), 
                new org.web3j.abi.datatypes.generated.Uint256(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claimOwnership() {
        final Function function = new Function(
                FUNC_CLAIMOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> operator() {
        final Function function = new Function(FUNC_OPERATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> updateOperator(String _newOperator) {
        final Function function = new Function(
                FUNC_UPDATEOPERATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOperator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> blacklisted(String param0) {
        final Function function = new Function(FUNC_BLACKLISTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> pendingOwner() {
        final Function function = new Function(FUNC_PENDINGOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<OperatorChangedEventResponse> getOperatorChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OPERATORCHANGED_EVENT, transactionReceipt);
        ArrayList<OperatorChangedEventResponse> responses = new ArrayList<OperatorChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OperatorChangedEventResponse typedResponse = new OperatorChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newOperator = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OperatorChangedEventResponse> operatorChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OperatorChangedEventResponse>() {
            @Override
            public OperatorChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OPERATORCHANGED_EVENT, log);
                OperatorChangedEventResponse typedResponse = new OperatorChangedEventResponse();
                typedResponse.log = log;
                typedResponse.newOperator = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OperatorChangedEventResponse> operatorChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATORCHANGED_EVENT));
        return operatorChangedEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    @Deprecated
    public static BlacklistStore load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlacklistStore(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BlacklistStore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlacklistStore(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BlacklistStore load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BlacklistStore(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BlacklistStore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BlacklistStore(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BlacklistStore> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlacklistStore.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlacklistStore> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlacklistStore.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BlacklistStore> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlacklistStore.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlacklistStore> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlacklistStore.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperatorChangedEventResponse {
        public Log log;

        public String newOperator;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
