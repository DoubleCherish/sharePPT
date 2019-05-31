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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
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
public class TokenStore extends Contract {
    private static final String BINARY = "60c0604052600960808190527f50696e67416e434e59000000000000000000000000000000000000000000000060a0908152620000409160049190620000cf565b506040805180820190915260048082527f50434e590000000000000000000000000000000000000000000000000000000060209092019182526200008791600591620000cf565b506006805460ff19166012179055620000a733620000ad602090811b901c565b62000174565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200011257805160ff191683800117855562000142565b8280016001018555821562000142579182015b828111156200014257825182559160200191906001019062000125565b506200015092915062000154565b5090565b6200017191905b808211156200015057600081556001016200015b565b90565b610f4b80620001846000396000f3fe608060405234801561001057600080fd5b50600436106101425760003560e01c80638da5cb5b116100b8578063da46098c1161007c578063da46098c146104c2578063e30443bc146104f8578063e30c397814610524578063e468688e1461052c578063f2fde38b14610549578063f7ea7a3d1461056f57610142565b80638da5cb5b1461042a57806395d89b411461043257806397d88cd21461043a578063ac7475ed14610470578063cf8eeb7e1461049657610142565b8063453920cb1161010a578063453920cb146102505780634e71e0c81461037d578063570ca735146103855780635c658165146103a95780635fd72d16146103d757806382838c761461040d57610142565b806306fdde031461014757806318160ddd146101c457806321e5383a146101de57806327e235e31461020c578063313ce56714610232575b600080fd5b61014f61058c565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610189578181015183820152602001610171565b50505050905090810190601f1680156101b65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101cc61061a565b60408051918252519081900360200190f35b61020a600480360360408110156101f457600080fd5b506001600160a01b038135169060200135610620565b005b6101cc6004803603602081101561022257600080fd5b50356001600160a01b03166106b9565b61023a6106cb565b6040805160ff9092168252519081900360200190f35b61020a6004803603604081101561026657600080fd5b81019060208101813564010000000081111561028157600080fd5b82018360208201111561029357600080fd5b803590602001918460018302840111640100000000831117156102b557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561030857600080fd5b82018360208201111561031a57600080fd5b8035906020019184600183028401116401000000008311171561033c57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506106d4945050505050565b61020a610750565b61038d610800565b604080516001600160a01b039092168252519081900360200190f35b6101cc600480360360408110156103bf57600080fd5b506001600160a01b0381358116916020013516610810565b61020a600480360360608110156103ed57600080fd5b506001600160a01b0381358116916020810135909116906040013561082d565b61020a6004803603602081101561042357600080fd5b50356108e4565b61038d61094d565b61014f61095c565b61020a6004803603606081101561045057600080fd5b506001600160a01b038135811691602081013590911690604001356109b7565b61020a6004803603602081101561048657600080fd5b50356001600160a01b0316610a3d565b61020a600480360360408110156104ac57600080fd5b506001600160a01b038135169060200135610b37565b61020a600480360360608110156104d857600080fd5b506001600160a01b03813581169160208101359091169060400135610bb0565b61020a6004803603604081101561050e57600080fd5b506001600160a01b038135169060200135610c2c565b61038d610c98565b61020a6004803603602081101561054257600080fd5b5035610ca7565b61020a6004803603602081101561055f57600080fd5b50356001600160a01b0316610d0a565b61020a6004803603602081101561058557600080fd5b5035610d8e565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106125780601f106105e757610100808354040283529160200191610612565b820191906000526020600020905b8154815290600101906020018083116105f557829003601f168201915b505050505081565b60035481565b6002546001600160a01b031633146106705760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b038216600090815260076020526040902054610699908263ffffffff610de316565b6001600160a01b0390921660009081526007602052604090209190915550565b60076020526000908152604090205481565b60065460ff1681565b6002546001600160a01b031633146107245760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b8151610737906004906020850190610e11565b50805161074b906005906020840190610e11565b505050565b6001546001600160a01b0316331461079c57604051600160e51b62461bcd028152600401808060200182810382526025815260200180610eca6025913960400191505060405180910390fd5b600154600080546040516001600160a01b0393841693909116917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360018054600080546001600160a01b03199081166001600160a01b03841617909155169055565b6002546001600160a01b03165b90565b600860209081526000928352604080842090915290825290205481565b6002546001600160a01b0316331461087d5760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b038084166000908152600860209081526040808320938616835292905220546108b3908263ffffffff610de316565b6001600160a01b03938416600090815260086020908152604080832095909616825293909352929091209190915550565b6002546001600160a01b031633146109345760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b600354610947908263ffffffff610dfc16565b60035550565b6000546001600160a01b031690565b6005805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106125780601f106105e757610100808354040283529160200191610612565b6002546001600160a01b03163314610a075760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b038084166000908152600860209081526040808320938616835292905220546108b3908263ffffffff610dfc16565b6000546001600160a01b03163314610a9f5760408051600160e51b62461bcd02815260206004820152601a60248201527f6d73672e73656e6465722073686f756c64206265206f776e6572000000000000604482015290519081900360640190fd5b6001600160a01b038116610ae757604051600160e51b62461bcd028152600401808060200182810382526031815260200180610eef6031913960400191505060405180910390fd5b600280546001600160a01b0319166001600160a01b0383811691909117918290556040519116907f4721129e0e676ed6a92909bb24e853ccdd63ad72280cc2e974e38e480e0e6e5490600090a250565b6002546001600160a01b03163314610b875760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b038216600090815260076020526040902054610699908263ffffffff610dfc16565b6002546001600160a01b03163314610c005760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b0392831660009081526008602090815260408083209490951682529290925291902055565b6002546001600160a01b03163314610c7c5760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b6001600160a01b03909116600090815260076020526040902055565b6001546001600160a01b031690565b6002546001600160a01b03163314610cf75760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b600354610947908263ffffffff610de316565b6000546001600160a01b03163314610d6c5760408051600160e51b62461bcd02815260206004820152601a60248201527f6d73672e73656e6465722073686f756c64206265206f776e6572000000000000604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b0392909216919091179055565b6002546001600160a01b03163314610dde5760408051600160e51b62461bcd02815260206004820152601d6024820152600080516020610eaa833981519152604482015290519081900360640190fd5b600355565b600082820183811015610df557600080fd5b9392505050565b600082821115610e0b57600080fd5b50900390565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610e5257805160ff1916838001178555610e7f565b82800160010185558215610e7f579182015b82811115610e7f578251825591602001919060010190610e64565b50610e8b929150610e8f565b5090565b61080d91905b80821115610e8b5760008155600101610e9556fe6d73672e73656e6465722073686f756c64206265206f70657261746f720000006d73672e73656e6465722073686f756c64206265206f6e6c7950656e64696e674f776e657243616e6e6f74206368616e676520746865206e65774f70657261746f7220746f20746865207a65726f2061646472657373a165627a7a72305820e8217bc899d028f36e529846232bc044958e2bf861e5d2a776bc5f300e8157c90029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_ADDBALANCE = "addBalance";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_CHANGETOKENNAME = "changeTokenName";

    public static final String FUNC_CLAIMOWNERSHIP = "claimOwnership";

    public static final String FUNC_OPERATOR = "operator";

    public static final String FUNC_ALLOWED = "allowed";

    public static final String FUNC_ADDALLOWANCE = "addAllowance";

    public static final String FUNC_SUBTOTALSUPPLY = "subTotalSupply";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_SUBALLOWANCE = "subAllowance";

    public static final String FUNC_UPDATEOPERATOR = "updateOperator";

    public static final String FUNC_SUBBALANCE = "subBalance";

    public static final String FUNC_SETALLOWANCE = "setAllowance";

    public static final String FUNC_SETBALANCE = "setBalance";

    public static final String FUNC_PENDINGOWNER = "pendingOwner";

    public static final String FUNC_ADDTOTALSUPPLY = "addTotalSupply";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETTOTALSUPPLY = "setTotalSupply";

    public static final Event OPERATORCHANGED_EVENT = new Event("OperatorChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected TokenStore(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TokenStore(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TokenStore(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TokenStore(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addBalance(String _holder, BigInteger _value) {
        final Function function = new Function(
                FUNC_ADDBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> changeTokenName(String _name, String _symbol) {
        final Function function = new Function(
                FUNC_CHANGETOKENNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_symbol)), 
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

    public RemoteCall<BigInteger> allowed(String param0, String param1) {
        final Function function = new Function(FUNC_ALLOWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addAllowance(String _holder, String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_ADDALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> subTotalSupply(BigInteger _value) {
        final Function function = new Function(
                FUNC_SUBTOTALSUPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> subAllowance(String _holder, String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_SUBALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updateOperator(String _newOperator) {
        final Function function = new Function(
                FUNC_UPDATEOPERATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOperator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> subBalance(String _holder, BigInteger _value) {
        final Function function = new Function(
                FUNC_SUBBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setAllowance(String _holder, String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_SETALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setBalance(String _holder, BigInteger _value) {
        final Function function = new Function(
                FUNC_SETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_holder), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> pendingOwner() {
        final Function function = new Function(FUNC_PENDINGOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addTotalSupply(BigInteger _value) {
        final Function function = new Function(
                FUNC_ADDTOTALSUPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setTotalSupply(BigInteger _value) {
        final Function function = new Function(
                FUNC_SETTOTALSUPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
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
    public static TokenStore load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenStore(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TokenStore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenStore(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TokenStore load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TokenStore(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TokenStore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TokenStore(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TokenStore> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TokenStore.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TokenStore> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TokenStore.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TokenStore> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TokenStore.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TokenStore> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TokenStore.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
