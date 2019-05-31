package com.pinganfu.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class AdminUpgradeabilityProxy extends Contract {
    private static final String BINARY = "6080604052604051610a53380380610a538339810180604052606081101561002657600080fd5b815160208301516040840180519294919382019264010000000081111561004c57600080fd5b8201602081018481111561005f57600080fd5b815164010000000081118282018710171561007957600080fd5b5050929190505050828160405180806109f5602391396040519081900360230190206000805160206109b48339815191521490506100b357fe5b6100c28261021c60201b60201c565b80511561017a576000826001600160a01b0316826040518082805190602001908083835b602083106101055780518252601f1990920191602091820191016100e6565b6001836020036101000a038019825116818451168082178552505050505050905001915050600060405180830381855af49150503d8060008114610165576040519150601f19603f3d011682016040523d82523d6000602084013e61016a565b606091505b505090508061017857600080fd5b505b5050604080517f6f72672e7a657070656c696e6f732e70726f78792e61646d696e0000000000008152905190819003601a019020600080516020610994833981519152146101c457fe5b6040518060216109d482396040519081900360210190207f54ac2bd5363dfe95a011c5b5a153968d77d153d212e900afce8624fdad74525c14905061020557fe5b6102148261029660201b60201c565b5050506102ae565b61022f816102a860201b6106381760201c565b610284576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252603b815260200180610a18603b913960400191505060405180910390fd5b6000805160206109b483398151915255565b60008051602061099483398151915255565b3b151590565b6106d7806102bd6000396000f3fe6080604052600436106100705760003560e01c80635c60da1b1161004e5780635c60da1b1461015e57806377f50f97146101735780638f28397014610188578063f851a440146101bb57610070565b8063267822471461007a5780633659cfe6146100ab5780634f1ef286146100de575b6100786101d0565b005b34801561008657600080fd5b5061008f6101ea565b604080516001600160a01b039092168252519081900360200190f35b3480156100b757600080fd5b50610078600480360360208110156100ce57600080fd5b50356001600160a01b031661024a565b610078600480360360408110156100f457600080fd5b6001600160a01b03823516919081019060408101602082013564010000000081111561011f57600080fd5b82018360208201111561013157600080fd5b8035906020019184600183028401116401000000008311171561015357600080fd5b509092509050610284565b34801561016a57600080fd5b5061008f610331565b34801561017f57600080fd5b5061007861035c565b34801561019457600080fd5b50610078600480360360208110156101ab57600080fd5b50356001600160a01b03166103fa565b3480156101c757600080fd5b5061008f610424565b6101d861044f565b6101e86101e36104b2565b6104d7565b565b60006101f46104fb565b6001600160a01b0316336001600160a01b0316148061022b5750610216610520565b6001600160a01b0316336001600160a01b0316145b1561023f57610238610520565b9050610247565b6102476101d0565b90565b6102526104fb565b6001600160a01b0316336001600160a01b031614156102795761027481610545565b610281565b6102816101d0565b50565b61028c6104fb565b6001600160a01b0316336001600160a01b03161415610324576102ae83610545565b6000836001600160a01b031683836040518083838082843760405192019450600093509091505080830381855af49150503d806000811461030b576040519150601f19603f3d011682016040523d82523d6000602084013e610310565b606091505b505090508061031e57600080fd5b5061032c565b61032c6101d0565b505050565b600061033b6104fb565b6001600160a01b0316336001600160a01b0316141561023f576102386104b2565b610364610520565b6001600160a01b0316336001600160a01b031614156103f2577f7e644d79422f17c01e4894b5f4f588d331ebfa28653d42ae832dc59e38c9798f6103a66104fb565b6103ae610520565b604080516001600160a01b03938416815291909216602082015281519081900390910190a16103e36103de610520565b610585565b6103ed60006105a9565b6101e8565b6101e86101d0565b6104026104fb565b6001600160a01b0316336001600160a01b0316141561027957610274816105a9565b600061042e6104fb565b6001600160a01b0316336001600160a01b0316141561023f576102386104fb565b6104576104fb565b6001600160a01b0316336001600160a01b031614156104aa57604051600160e51b62461bcd02815260040180806020018281038252603281526020018061063f6032913960400191505060405180910390fd5b6101e86101e8565b7f7050c9e0f4ca769c69bd3a8ef740bc37934f8e2c036e5a723fd8ee048ed3f8c35490565b3660008037600080366000845af43d6000803e8080156104f6573d6000f35b3d6000fd5b7f10d6a54a4754c8869d6886b5f5d7fbfa5b4522237ea5c60d11bc4e7a1ff9390b5490565b7f54ac2bd5363dfe95a011c5b5a153968d77d153d212e900afce8624fdad74525c5490565b61054e816105cd565b6040516001600160a01b038216907fbc7cd75a20ee27fd9adebab32041f755214dbc6bffa90cc0225b39da2e5c2d3b90600090a250565b7f10d6a54a4754c8869d6886b5f5d7fbfa5b4522237ea5c60d11bc4e7a1ff9390b55565b7f54ac2bd5363dfe95a011c5b5a153968d77d153d212e900afce8624fdad74525c55565b6105d681610638565b61061457604051600160e51b62461bcd02815260040180806020018281038252603b815260200180610671603b913960400191505060405180910390fd5b7f7050c9e0f4ca769c69bd3a8ef740bc37934f8e2c036e5a723fd8ee048ed3f8c355565b3b15159056fe43616e6e6f742063616c6c2066616c6c6261636b2066756e6374696f6e2066726f6d207468652070726f78792061646d696e43616e6e6f742073657420612070726f787920696d706c656d656e746174696f6e20746f2061206e6f6e2d636f6e74726163742061646472657373a165627a7a7230582081d658c57d0aa42dc1c7bfd0bda7bd84cbc65cffd2108a806bf3033e0556aca4002910d6a54a4754c8869d6886b5f5d7fbfa5b4522237ea5c60d11bc4e7a1ff9390b7050c9e0f4ca769c69bd3a8ef740bc37934f8e2c036e5a723fd8ee048ed3f8c36f72672e7a657070656c696e6f732e70726f78792e70656e64696e6741646d696e6f72672e7a657070656c696e6f732e70726f78792e696d706c656d656e746174696f6e43616e6e6f742073657420612070726f787920696d706c656d656e746174696f6e20746f2061206e6f6e2d636f6e74726163742061646472657373";

    public static final String FUNC_PENDINGADMIN = "pendingAdmin";

    public static final String FUNC_UPGRADETO = "upgradeTo";

    public static final String FUNC_UPGRADETOANDCALL = "upgradeToAndCall";

    public static final String FUNC_IMPLEMENTATION = "implementation";

    public static final String FUNC_CLAIMADMIN = "claimAdmin";

    public static final String FUNC_CHANGEADMIN = "changeAdmin";

    public static final String FUNC_ADMIN = "admin";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event UPGRADED_EVENT = new Event("Upgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected AdminUpgradeabilityProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AdminUpgradeabilityProxy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AdminUpgradeabilityProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AdminUpgradeabilityProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> pendingAdmin() {
        final Function function = new Function(
                FUNC_PENDINGADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> upgradeTo(String newImplementation) {
        final Function function = new Function(
                FUNC_UPGRADETO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newImplementation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> upgradeToAndCall(String _newImplementation, byte[] _data, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_UPGRADETOANDCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newImplementation), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> implementation() {
        final Function function = new Function(
                FUNC_IMPLEMENTATION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claimAdmin() {
        final Function function = new Function(
                FUNC_CLAIMADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeAdmin(String _newAdmin) {
        final Function function = new Function(
                FUNC_CHANGEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newAdmin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> admin() {
        final Function function = new Function(
                FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<AdminChangedEventResponse> getAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<AdminChangedEventResponse> responses = new ArrayList<AdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AdminChangedEventResponse>() {
            @Override
            public AdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADMINCHANGED_EVENT, log);
                AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCHANGED_EVENT));
        return adminChangedEventFlowable(filter);
    }

    public List<UpgradedEventResponse> getUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPGRADED_EVENT, transactionReceipt);
        ArrayList<UpgradedEventResponse> responses = new ArrayList<UpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpgradedEventResponse typedResponse = new UpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UpgradedEventResponse>() {
            @Override
            public UpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPGRADED_EVENT, log);
                UpgradedEventResponse typedResponse = new UpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPGRADED_EVENT));
        return upgradedEventFlowable(filter);
    }

    @Deprecated
    public static AdminUpgradeabilityProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AdminUpgradeabilityProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AdminUpgradeabilityProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AdminUpgradeabilityProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AdminUpgradeabilityProxy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AdminUpgradeabilityProxy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AdminUpgradeabilityProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AdminUpgradeabilityProxy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AdminUpgradeabilityProxy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String _implementation, String _admin, byte[] _data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_implementation), 
                new org.web3j.abi.datatypes.Address(_admin), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)));
        return deployRemoteCall(AdminUpgradeabilityProxy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<AdminUpgradeabilityProxy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String _implementation, String _admin, byte[] _data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_implementation), 
                new org.web3j.abi.datatypes.Address(_admin), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)));
        return deployRemoteCall(AdminUpgradeabilityProxy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<AdminUpgradeabilityProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String _implementation, String _admin, byte[] _data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_implementation), 
                new org.web3j.abi.datatypes.Address(_admin), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)));
        return deployRemoteCall(AdminUpgradeabilityProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<AdminUpgradeabilityProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String _implementation, String _admin, byte[] _data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_implementation), 
                new org.web3j.abi.datatypes.Address(_admin), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)));
        return deployRemoteCall(AdminUpgradeabilityProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static class AdminChangedEventResponse {
        public Log log;

        public String previousAdmin;

        public String newAdmin;
    }

    public static class UpgradedEventResponse {
        public Log log;

        public String implementation;
    }
}
